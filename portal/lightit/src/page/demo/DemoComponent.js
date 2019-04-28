import React, { Component } from 'react';

const MyInput = ({ value = '', onChange }) => (
    <input value={value} onChange={onChange} />
);
class DemoComponent extends Component {
    state = {
        text: '',
    }

    onTextChange = (event) => {
        this.setState({ text: event.target.value });
    }
    onTextReset = () => {
        this.setState({ text: '' });
    }
    render() { 

        return (
            <div>
                <MyInput onChange={this.onTextChange} value={this.state.value} />
            </div>
        )
    }
}

export default DemoComponent