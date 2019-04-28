
class ShoppingList extends React.Component{
    render(){
        return (
            <div className="shopping-list">
                <h1>Shopping LIst for {this.props.name}</h1>
                <ul>
                    <li>S1</li>
                    <li>S2</li>
                    <li>S3</li>
                </ul>
            </div>
        )
    }
}

export default ShoppingList;