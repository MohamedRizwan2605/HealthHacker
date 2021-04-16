import React from 'react';
import { Card, Row, Col } from 'antd';

function DietChartComponent(){
    return(
        <div className="site-card-wrapper" >
        <Row gutter={16} style={{marginTop:16}}>
          <Col span={8}>
            <Card title="Monday Plan" bordered={false} >
                <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
          <Col span={8}>
            <Card title="Tuesday Plan" bordered={false}>
            <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
          <Col span={8}>
            <Card title="Wednesday Plan" bordered={false}>
            <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
        </Row>
        <Row gutter={16} style={{marginTop:16}}>
          <Col span={8}>
            <Card title="Thursday Plan" bordered={false}>
                <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
          <Col span={8}>
            <Card title="Friday Plan" bordered={false}>
            <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
          <Col span={8}>
            <Card title="Saturday Plan" bordered={false}>
            <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
        </Row>
        <Row gutter={16} style={{marginTop:16}}>
          <Col span={8}>
            <Card title="Sunday Plan" bordered={false}>
                <ul>
                    <li> Breakfast: Sambar with 2 brown rice idlis/ Paneer sandwich with mint chutney</li>
                    <li>Lunch: Whole-grain roti with mixed-vegetable curry with one dal</li>
                    <li>Dinner: Tofu/chicken curry with mixed vegetables and a fresh spinach salad/chicken gravy with 2 multigrain rotis</li>
                </ul>
            </Card>
          </Col>
        </Row>
      </div>
    )
}

export default DietChartComponent;