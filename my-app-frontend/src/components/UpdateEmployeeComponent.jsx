import React, {Component} from "react";
import ListEmployeeService from "../service/ListEmployeeService";

class UpdateEmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            firstName: " ",
            lastName: " ",
            emailId: " "
        };
        this.changeFirstNameHandle = this.changeFirstNameHandle.bind(this);
        this.changeLastNameHandle = this.changeLastNameHandle.bind(this);
        this.updateEmployee = this.updateEmployee.bind(this);
    }

    componentDidMount() {
        ListEmployeeService.getEmployeeById(this.state.id).then((resp) => {
            let employee = resp.data;
            this.setState({
                firstName: employee.firstName,
                lastName: employee.lastName,
                emailId: employee.emailId
            });
        });
    }

    updateEmployee = (e) => {
        e.preventDefault();
        let employee = {firstName: this.state.firstName, lastName: this.state.lastName, emailId: this.state.emailId};
        console.log('employee => ' + JSON.stringify(employee));
        ListEmployeeService.updateEmployee(employee, this.state.id).then(
            resp => {
                this.props.history.push('/employees');
            }
        )
    };

    changeFirstNameHandle = (event) => {
        this.setState({firstName: event.target.value});
    };

    changeLastNameHandle = (event) => {
        this.setState({lastName: event.target.value});
    };

    changeEmailIdHandle = (event) => {
        this.setState({emailId: event.target.value});
    };

    cancel() {
        this.props.history.push('/employees')
    };

    render() {
        return (<div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Update</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>First Name:</label>
                                        <br/>
                                        <input type="text" placeholder={"First Name"} name="firstName"
                                               value={this.state.firstName}
                                               onChange={this.changeFirstNameHandle}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Last Name:</label>
                                        <br/>
                                        <input placeholder="Last Name" name="lastName" value={this.state.lastName}
                                               onChange={this.changeLastNameHandle}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Email:</label>
                                        <br/>
                                        <input placeholder="Email" name="emailId" value={this.state.emailId}
                                               onChange={this.changeEmailIdHandle}/>
                                    </div>

                                    <button className="btn btn-success" onClick={this.updateEmployee}>Update</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}
                                            style={{marginLeft: "10px"}}>Cancel
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}


export default UpdateEmployeeComponent;