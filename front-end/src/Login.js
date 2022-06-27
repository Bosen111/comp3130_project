import {Button} from "antd";
import React from "react";
import './login.css'

class Login extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      keyVal: 1,
      pageTab: 'login',
      username: null,
      password: null,
      email: null
    }
  }
  render(){
    return (
      <div className="login-wrapper">
        <div className="title">
          <p>Web name</p>
          <div className="right-button">
            <Button type="primary" onClick={() => this.chooseLogin('login')}>Login</Button>
            <Button type="primary" danger onClick={() => this.chooseLogin('registration')}>Registration</Button>
          </div>
        </div>
        <div className="tabs">
          <div className="tabs-item">
            <p onClick={() => this.chooseKey(1)} className={this.state.keyVal === 1?'active': null}>Home</p>
            <p onClick={() => this.chooseKey(2)} className={this.state.keyVal === 2?'active': null}>Culture</p>
            <p onClick={() => this.chooseKey(3)} className={this.state.keyVal === 3?'active': null}>About Us</p>
          </div>
          <div className="tabs-content">

            <div className="show-content">
              {this.state.keyVal === 1 && <div className="login-page">
                {this.state.pageTab === 'login' &&<div className="login-wrapper">
                  <div className="input-item">
                    <p>User name</p>
                    <input type="text" placeholder='please input your Username...' onChange={(e) => this.inputChangeUsername(e)}/>
                  </div>
                  <div className="input-item">
                    <p>Password</p>
                    <input type="password" placeholder='please input your Password...' onChange={(e) => this.inputChangePassword(e)}/>
                  </div>
                  <Button onClick={() => this.userLogin()}>Login</Button>
                </div>}
                {this.state.pageTab === 'registration' && <div className="login-wrapper">
                  <div className="input-item">
                    <p>User name</p>
                    <input type="text" placeholder='please input your Username...' onChange={(e) => this.inputChangeUsername(e)}/>
                  </div>
                  <div className="input-item">
                    <p>Password</p>
                    <input type="password" placeholder='please input your Password...' onChange={(e) => this.inputChangePassword(e)}/>
                  </div>
                  <div className="input-item">
                    <p>Email</p>
                    <input type="password" placeholder='please input your Email...' onChange={(e) => this.inputChangeEmail(e)}/>
                  </div>
                  <Button onClick={() => this.userRegistration()}>registration</Button>
                </div>}
              </div>}
              {this.state.keyVal === 2 && <div className="culture-wrapper">
                <p>this is culture page</p>
              </div>}
              {this.state.keyVal === 3 && <div className="about-wrapper">
                <p>this is aboutUs page</p>
              </div>}
            </div>
          </div>
        </div>
        <div className="footer">

        </div>
      </div>
    )
  }

  chooseKey(index){
    this.setState({
      keyVal: index
    })
  }
  chooseLogin(type){
    this.setState({
      pageTab: type,
      username: null,
      password: null,
      email: null
    })
  }
  userLogin(){
    if(this.state.username && this.state.password){
      alert('you can Login')
    }
  }
  userRegistration(){
    if(this.state.username && this.state.password && this.state.email){
      alert('you can Registration')
    }
  }
  inputChangeUsername(e){
    this.setState({
      username: e.target.value
    })
  }
  inputChangePassword(e){
    this.setState({
      password: e.target.value
    })
  }
  inputChangeEmail(e){
    this.setState({
      email: e.target.value
    })
  }
}

export default Login;
