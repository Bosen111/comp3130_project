import React from "react";
import '../login.css'
import {Container, Nav, Navbar} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';

function Navigation(){
    if (localStorage.getItem("logState") == null) {
        return (
            <>
                <Navbar bg="primary" variant="dark">
                    <Container>

                        <Nav className="me-auto">
                            <Nav.Link href="/">Home</Nav.Link>
                            <Nav.Link href="/login">Login</Nav.Link>
                            <Nav.Link href="/register">Register</Nav.Link>
                            <Nav.Link href="/forgotPw">Forgot-Password</Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>
            </>
        );
    } else {
        return (
            <>
                <Navbar bg="primary" variant="dark">
                    <Container>

                        <Nav className="me-auto">
                            <Nav.Link href="/">Home</Nav.Link>
                            <Nav.Link href="/Workspace">Workspace</Nav.Link>
                            <Nav.Link href="/Workspaces">Workspaces</Nav.Link>
                            <Nav.Link href="/Logout">Logout</Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>
            </>
        );
    }
}

export default Navigation;