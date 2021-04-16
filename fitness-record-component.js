import React from 'react';
import {Table, Row, Empty} from 'antd';
import FitnessDetails from './fitness-details-records';

function FitnessResult(props){

    return(
      <FitnessDetails  history={props.history}/>
    )
}

export default FitnessResult;