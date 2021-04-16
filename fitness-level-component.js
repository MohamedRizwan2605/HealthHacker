import React from 'react';
import LevelDetails from './level-detail-component';
import CourseInfo from './course-info-component';
import {getServer, postServer}  from '../utils/api_file';

function FitnessLevel(props){

    return(
      <div >
    <LevelDetails />
    <CourseInfo history={props.history} />
    </div>
    )
}

export default FitnessLevel;