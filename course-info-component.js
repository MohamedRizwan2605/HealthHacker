import React, { useState, useEffect } from 'react';
import { Card, Row, Col, Button, Divider, Input, DatePicker, TimePicker, Select, Alert, message } from 'antd';
import {getServer, postServer}  from '../utils/api_file';

const { RangePicker } = DatePicker;
const { Option } = Select;

function CourseInfo(props){
    
  let data=[];

  const [detailsValue, setDetailsValue] = useState([{}]);

  useEffect(() =>{
    getServer('/getLevel?mailId=xyz@gmail.com').then(res=>{
        if(res.status == 200){
          console.log(res.data);
          setDetailsValue(res.data);
          
        }else{
          console.log("Insertion failed.")
        }
      })

  },[])

    const [startDate, setStartDate] = useState("");

    const [endDate, setEndDate] = useState("");

    const [courseTime, setCourseTime] = useState(0);

    const [levelType, setLevelType] = useState("begin");

    const [height, setHeight] = useState(150);

    const [weight, setWeight] = useState(60);

    const [age, setAge] = useState(15);

    function getCourseDuration(value){
      setStartDate(value[0]._d.toDateString());
      setEndDate(value[1]._d.toDateString());

    }

    function getBmidetail(){
      const bmiMeterSquare=(height*0.01)^2
      const bmiValue= weight/bmiMeterSquare;
      const bmiParam = {"bmiId": bmiValue,
      "height": height,
      "weight": weight,
      "age": age}
     
    postServer('/addBmi?mailId=xyz@gmail.com',bmiParam).then(res=>{
      if(res.status == 200){
        console.log(res);
        message.success('BMI Details saved successfully!');
      }else{
        message.error('Insertion failed.');
      }
    })
    }
    function getCoursedetail(){
      let levelVal=1;
      switch (levelType) {
        case "begin":
          levelVal= 1;
          break;
        case "inter":
          levelVal= 2;
          break;
        case "advanced":
          levelVal= 3;
        default:
          break;
      }

      const levelParam = {"levelId": levelVal,
      "startDate": startDate,
      "endDate": endDate,
      "dailyHours": courseTime
      }
    
    postServer('/addLevel?mailId=xyz@gmail.com',levelParam).then(res=>{
      if(res.status == 200){
        // props.history.push("/workoutPlan");
        setDetailsValue(res.data);
        message.success('Course Details saved successfully!');
      }else{
        message.error('Insertion failed.');
      }
    });
    }
    const value="xyz@gmail.com";
    const str = (detailsValue[0].userLevelEntity === null || detailsValue[0].userLevelEntity === undefined) ? "" : 
    "Course Type : " + detailsValue[0].userLevelEntity.levelId + " | Start Date : " +detailsValue[0].userLevelEntity.startDate +
    " | End Date : " +detailsValue[0].userLevelEntity.endDate;
    const id = detailsValue[0].userLevelEntity === null || detailsValue[0].userLevelEntity === undefined ? 0 : detailsValue[0].userLevelEntity.levelId;
    return(
      (detailsValue[0].userLevelEntity === null || detailsValue[0].userLevelEntity === undefined) 
     || (detailsValue[0].userBmiEntity === null || detailsValue[0].userBmiEntity === undefined)  ?
    <Row style={{marginTop:24}}>
    <Col span={1} />
    <Col span={22} >
    <Card elevation={3} bordered={false} style={{backgroundColor : "#e6f7ff"}}>
    <Row>
    <Col span={12} >
    <h5 style={{color : "#001529"}}>Course Information</h5>
    <label style={{width:130}}>Course Start Date</label>
    <RangePicker onChange={getCourseDuration} style={{marginTop : 16}}/>
    <br />
    <label style={{width:130}}>Exercise Duration</label>
    <TimePicker format='mm' onChange={value => setCourseTime(value._d.getMinutes())} style={{marginTop : 16}}/>
    <br />
    <label style={{width:130}}>Course Level</label>
    <Select defaultValue={levelType} onSelect={(value)=>setLevelType(value)} style={{marginTop : 16, width: 240}}>
      <Option value="begin">Beginner</Option>
      <Option value="inter">Intermediate</Option>
      <Option value="Advance">Expert</Option>
    </Select>
    </Col>
    <Col span={2} >
    <Divider type="vertical" style={{height : "100%", marginLeft:"50%"}}/>
    </Col>
    <Col span={8} >
    <h5 style={{color : "#001529"}}>Current BMI</h5>
    <Input placeholder="Enter the height" suffix="cm" onChange={(event)=>setHeight(event.target.value)} style={{marginTop : 16}}/>
    <Input placeholder="Enter the weight" suffix="Kg" onChange={(event)=>setWeight(event.target.value)} style={{marginTop : 16}}/>
    <Input placeholder="Age" onChange={(event)=>setAge(event.target.value)} style={{marginTop : 16}}/>
    </Col>
    </Row>
    <Row  style={{marginTop : 16}}>
    <Col justify="center" span={14} >
    <Button type="primary" shape="round" onClick={getCoursedetail}>
     Submit Course Details
   </Button>
    </Col>
    <Col justify="center" span={10} >
    <Button type="primary" shape="round" onClick={getBmidetail}>
     Submit BMI Details
   </Button>
    </Col>
 
    </Row>
        </Card>
    </Col>
    <Col span={1} />
    </Row> :
    <Row style={{marginTop:24}}>
    <Col span={1} />
    <Col span={20} >
    <Alert
      message={str}
      type="info"
    />
    </Col>
    <Col span={2} >
    <Button type="primary" style={{height:"100%"}} onClick={()=>props.history.push("/workoutPlan/"+id)} block>
     Start
   </Button>
        </Col>
    <Col span={1} />
    </Row>
    )
}

export default CourseInfo;