import React, { useState, useEffect } from 'react';
import { Layout, Button, Row, Image, Progress } from 'antd';
import DailyChartInfo from './daily-chart-info';
import dumbbell from '../images/dumbbells.jpg';
import { useParams } from 'react-router-dom';
import {getServer, postServer}  from '../utils/api_file';

const { Header, Content } = Layout;

function DailyReportComponent(props){
  return <DailyChartInfo history={props.history}/>
}



export default DailyReportComponent;