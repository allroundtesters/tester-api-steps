import React from 'react';
import ShoppingList from './Shoppinglist';

class Shopping extends React.Component{
    //name pass to child component's props, props have default properties: children
    componentDidMount() {
        console.log("learning component lifecycle - did mount");
    }
  
    componentWillUnmount() {
  
        console.log("learning component lifecycle-will unmount");
    }
  
    componentDidUpdate() {
    console.log("learning component lifecycle-did update");
    
    }
    shouldComponentUpdate(nextProps, nextState){
        console.log("should component update?")
    }
    static getDerivedStateFromProps(props, state){
        console.log("before rendering");
    }
    getSnapshotBeforeUpdate(){
        console.log("after dom changes, and pass to componentDidUpdate")
    }

    render(){
        const Picture = (props) => {
            return (
              <div>
                <img src={props.src} />
                {props.children}
              </div>
            )
          }
       
        return(
            <div>
                <ShoppingList name="simon"/> 
            </div>

        )
    }
}

export default Shopping