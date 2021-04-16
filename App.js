import React from 'react';
import { Route, Switch, HashRouter, Redirect } from 'react-router-dom';
import { createHashHistory } from 'history';
import Home from './components/home-page-component';
import WorkoutPlanComponent from './components/workout-plan-component';
import DietPlanComponent from './components/diet-plan-component';
import DailyReportComponent from './components/daily-report-component';

const history = createHashHistory();
function App() {
  return (
    <HashRouter history={history}>
               <Switch>
                  <Route exact path='/' render={() => (<Redirect to="/homePage" />)} />
                  <Route path='/homePage' component={Home} />
                  <Route path='/workoutPlan' component={WorkoutPlanComponent} />
                  <Route path='/dietPlan' component={DietPlanComponent} />
                  <Route path='/dailyReport/:id' component={DailyReportComponent} />
               </Switch>
         </HashRouter>
  );
}

export default App;
