import React, { Component } from "react";
import { Tabs,Tree } from "antd";

class DemoTab extends Component {
    state = {
        activeKey: 1
    }
    onTabChange = (activeKey) => {
        this.setState({
            activeKey: activeKey
        })
    }
    render() {
        return (

            <div>
                <Tabs activeKey={this.state.acrtiveKey} onChange={this.onTabChange}>
                    <TabPane tab="tab 1" ke="1">Tab1</TabPane>
                    <TabPane tab="tab 2" ke="2">Tab2</TabPane>
                    <TabPane tab="tab 3" ke="3">Tab3</TabPane>
                    <TabPane tab="tab 4" ke="4">Tab4</TabPane>
                </Tabs>
                <Tree>
                    <TreeNode title="parent1" key="0-0"></TreeNode>
                    <TreeNode title="leaf1" key="0-1"></TreeNode>
                    <TreeNode title="leaf2" key="0-2"></TreeNode>
                    <TreeNode></TreeNode>
                </Tree>
            </div>
        )
    }
}

export default DemoTab;