import React, { useState, useEffect } from 'react';
import {Result, Button, Descriptions, Slider, Row, Modal, Table} from 'antd';
import { InfoCircleOutlined } from '@ant-design/icons';
import {getServer, postServer}  from '../utils/api_file';

function BmiInfo(props){

    const [detailsValue, setDetailsValue] = useState([{}]);

    
    useEffect(() =>{
      getServer('/getBmi?mailId=xyz@gmail.com').then(res=>{
          if(res.status == 200){
            console.log(res.data);
            setDetailsValue(res.data);
            
          }else{
            console.log("Insertion failed.")
          }
        })
  
    },[])


const columns = [
  {
    title: 'Category',
    dataIndex: 'name',
    key: 'name'
  },
  {
    title: 'BMI range - kg/m2',
    dataIndex: 'bmi',
    key: 'bmi',
  }
];

const data = [
  {
    key: '1',
    name: 'Severe Thinness',
    bmi: '< 16'
  },
  {
    key: '2',
    name: 'Moderate Thinness',
    bmi: '16 - 17'
  },
  {
    key: '3',
    name: 'Mild Thinness',
    bmi: '17 - 18.5'
  },
  {
    key: '4',
    name: 'Normal',
    bmi: '18.5 - 25'
  },
  {
    key: '5',
    name: 'Overweight',
    bmi: '25 - 30'
  },
  {
    key: '6',
    name: 'Obese Class I',
    bmi: '30 - 35'
  },
  {
    key: '7',
    name: 'Obese Class II',
    bmi: '35 - 40'
  },
  {
    key: '8',
    name: 'Obese Class III',
    bmi: '> 40'
  },
];

    function info() {
      Modal.info({
        title: 'Details about BMI chart',
        content: (
          <Table columns={columns} dataSource={data} pagination={false} size="small"/>
        ),
        onOk() {},
      });
    }

    return( (detailsValue[0].userBmiEntity === null || detailsValue[0].userBmiEntity === undefined) ?
      <Result style={{color : "aliceblue"}}
      status="404"
      title="Sorry, Fill the BMI information in home page!"
    /> :
      <Descriptions title="BMI Info" bordered>
        <Descriptions.Item label="Height(in cm)">
         <label style={{color : "aliceblue"}}>{detailsValue[0].userBmiEntity.height}</label> 
          </Descriptions.Item>
        <Descriptions.Item label="Weight(in Kg)" span={2}>
        <label style={{color : "aliceblue"}}>{detailsValue[0].userBmiEntity.weight}</label> 
        </Descriptions.Item>
        <Descriptions.Item label="BMI Value(in units)" span={3}>
        <label style={{color : "aliceblue"}}>{detailsValue[0].userBmiEntity.weight/(detailsValue[0].userBmiEntity.height/100*detailsValue[0].userBmiEntity.height/100)}</label> 
        <span style={{marginLeft : 16, color : "aliceblue"}}><InfoCircleOutlined onClick={info}/></span>
        </Descriptions.Item>
        <Descriptions.Item label="Age" span={3}>
        <label style={{color : "aliceblue"}}>{detailsValue[0].userBmiEntity.age}</label> 
        </Descriptions.Item>
        <Descriptions.Item label="BMI Scale">
        <Slider defaultValue={detailsValue[0].userBmiEntity.weight/(detailsValue[0].userBmiEntity.height/100*detailsValue[0].userBmiEntity.height/100)} />
    </Descriptions.Item>
  </Descriptions> 
       
    )
}

export default BmiInfo;