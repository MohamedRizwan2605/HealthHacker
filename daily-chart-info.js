import React, { useState, useEffect } from 'react';
import { Layout, Button, Row, Image, Progress } from 'antd';
import dumbbell from '../images/dumbbells.jpg';
import { useParams } from 'react-router-dom';
import {getServer, postServer}  from '../utils/api_file';

const { Header, Content } = Layout;




function DailyChartInfo(props){
    const [detailsValue, setDetailsValue] = useState([]);
    const { id } = useParams();

    useEffect(() =>{
        getServer('/getDetails/'+id).then(res=>{
            if(res.status == 200){
              
              setDetailsValue(res.data);
              // setDetailsValue(detailsVal);
      
            }else{
              console.log("Insertion failed.")
            }
          })

    })

    return(
        <div>
{detailsValue.map(values =>(
<Layout>
          <Header style={{ background: '#001529', padding: 0 }}>
          <span style={{marginLeft : 16}}>
            <label style={{color : "aliceblue", fontSize: "x-large"}}>Daily Health Report</label></span>
          </Header>
          <Content style={{ background: '#001529c7', overflowY:"hidden", overflowX:"hidden"}}>
          <Image src={dumbbell} className="bg-image"/>
          <div class="bg-text">
    <h1 style={{color : "aliceblue"}}>Well Done!!!</h1>
    <Row justify="center">
    <label style={{color : "aliceblue", marginTop:16}}>Calories Burnt : 
      <span style={{marginLeft:16}}  class="badge badge-success">{values.userWorkoutDetailsList[0].caloriesBurnt}</span></label>
    </Row>
    <Row justify="center">
    <label style={{color : "aliceblue", marginTop:16}}>Predictor : 
    <span style={{marginLeft:16}}  class="badge badge-secondary">{values.userWorkoutDetailsList[0].weightPredictor}</span></label>
    </Row>
    <Row justify="center">
    <label style={{color : "aliceblue", marginTop:16}}>Progress : <span style={{marginLeft:16}} class="badge badge-info">{values.userWorkoutDetailsList[0].progressPercent}</span></label>
    </Row>
    <Row justify="center" style={{marginTop:16}}>
    <Progress type="circle" percent={values.userWorkoutDetailsList[0].progressPercent} />
    </Row>
    <Row justify="center" style={{marginTop:16}}>
          <Button type="primary" shape="round" onClick={()=>props.history.push("/homePage")}>
          Back Home
        </Button>
              </Row>
    </div>
          </Content>
        </Layout>
    

))}
        </div>
    )
         
} 

export default DailyChartInfo;