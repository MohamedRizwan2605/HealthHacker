import React from 'react';
import FitnessLevel from './fitness-level-component';
import FitnessResult from './fitness-record-component';
import BmiInfo from './bmi-info-component';

function FitnessMain(props){
      return (
             props.menu === "home" ? <FitnessLevel history={props.history}/> : props.menu === "record" ? 
             <FitnessResult /> 
             : <BmiInfo onMenuSelect={props.onMenuSelect}/>
      );
}
export default FitnessMain;