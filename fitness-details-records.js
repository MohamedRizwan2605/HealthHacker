import React, { useState, useEffect } from 'react';
import {Table, Row, Empty} from 'antd';
import { useParams } from 'react-router-dom';
import {getServer, postServer}  from '../utils/api_file';



function FitnessDetails(props){

    const columns = [
        { title: 'User Name', dataIndex: 'mailId', key: 'mailId' },
        { title: 'FirstName', dataIndex: 'firstName', key: 'firstName' },
        { title: 'Last Name', dataIndex: 'lastName', key: 'lastName' },
      ];


    const [detailsValue, setDetailsValue] = useState([{}]);
    const { id } = useParams();

    useEffect(() =>{
        getServer('/getBmi?mailId=xyz@gmail.com').then(res=>{
            if(res.status == 200){
              
              setDetailsValue(res.data);
              // setDetailsValue(detailsVal);
      
            }else{
              console.log("Insertion failed.")
            }
          })

    },[])

    return(
      (detailsValue[0].userLevelEntity === null || detailsValue[0].userLevelEntity === undefined ) ?
      <Empty style={{marginTop: "12%"}} description="Sorry, No Records Found, Start your course!"/>
      :
    <Table
    columns={columns}
    expandable={{
      expandedRowRender: record => <div>
      <Row>
      <label>Calories Burnt : {record.userLevelEntity.userWorkoutDetailsList.length > 0 && 
      record.userLevelEntity.userWorkoutDetailsList[0].caloriesBurnt} calories</label>
      </Row>
      <Row>
      <label>Percentage completed: {record.userLevelEntity.userWorkoutDetailsList.length > 0 && 
      record.userLevelEntity.userWorkoutDetailsList[0].progressPercent}</label>
      </Row>
    </div>
    }}
    dataSource={detailsValue}/>
    )
         
} 

export default FitnessDetails;