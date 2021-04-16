import React, { useState } from 'react';
import { Layout, Button, Row } from 'antd';
import DietChartComponent from './diet-chart-component';
import {getServer, postServer}  from '../utils/api_file';

const { Header, Content, Footer } = Layout;

function DietPlanComponent(props){

let data=[];

const [levelIdVal,setLevelIdVal] = useState(0);
getServer('/getBmi?mailId=xyz@gmail.com').then(res=>{
  if(res.status == 200){
    console.log(res.data);
    data=res.data;
    setLevelIdVal(data[0].userLevelEntity.levelId);

    console.log(data);
  }else{
    console.log("Insertion failed.")
  }
})

function saveDetails(){
  let detailsParam={};
  switch (levelIdVal) {
    case 1:
       detailsParam={
        "workDtlName" : "Biceps","workoutTimer" : "15" , "progressPercent": "90" ,"caloriesBurnt" : "1500" ,"weightPredictor": "1",
      "prcDate": "2020-09-25T15:35:35.073+00:00"
      };
      break;
    case 2:
         detailsParam={
          "workDtlName" : "Shoulder","workoutTimer" : "20" , "progressPercent": "70" ,"caloriesBurnt" : "2000" ,"weightPredictor": "2",
        "prcDate": "2020-09-25T15:35:35.073+00:00"
        };
        break;
      case 3:
           detailsParam={
            "workDtlName" : "Abs","workoutTimer" : "30" , "progressPercent": "60" ,"caloriesBurnt" : "3000" ,"weightPredictor": "4",
          "prcDate": "2020-09-25T15:35:35.073+00:00"
          };
          break;
    default:
      break;
  }

  postServer('/addDetails/'+levelIdVal,detailsParam).then(res=>{
    if(res.status == 200){
      props.history.push("/dailyReport/"+1);
    }else{
      console.log("Insertion failed.")
    }
  })

  
}

    return(
        <Layout>
          <Header style={{ background: '#001529', padding: 0 }}>
          <span style={{marginLeft : 16}}>
            <label style={{color : "aliceblue", fontSize: "x-large"}}>Diet Plan Schedule</label></span>
          </Header>
          <Content style={{ background: '#001529c7', overflowY:"auto", overflowX:"hidden"}}>
           <DietChartComponent/>
          </Content>
          <Footer style={{ background: '#001529c7'}}>
          <Row justify="center">
          <Button type="primary" shape="round" onClick={saveDetails}>
          Go to Result
        </Button>
              </Row>
          </Footer>
        </Layout>
    )
}

export default DietPlanComponent;