import React, { Component } from 'react';
import { Card, Button } from 'antd';
import {connect} from "dva";

const namespace = 'pcards';
const mapStateToProps = (state) => {
  const cardList = state[namespace].data;
  return {
    cardList,
  };
};

const mapDispatchToProps = (dispatch)=>{
  return {
    onDidMount: ()=>{
      dispatch({
        type: `${namespace}/queryInitCard`
      });
    }
  }
}

@connect(mapStateToProps,mapDispatchToProps)  //inject to 
export default class PCardsPage extends Component {
  componentDidMount(){
    this.props.onDidMount();
  }
  render() {
    console.log(this.props.cardList);
    return (
      <div>
        {
          this.props.cardList.map(card => {
            return (
              <Card key={card.id}>
                <div>Q: {card.setup}</div>
                <div>
                  <strong>A: {card.punchline}</strong>
                </div>
              </Card>
            );
          })
        }
       {/* <Button onClick={
         ()=>this.props.onClickAdd({
           setup: "this is new added card",
           punchiline: 'here is new added card'
         })
       }>
         Add New Card
       </Button> */}
      </div>
    );
  }

}