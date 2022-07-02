import React from "react";
import '../login.css'
import {Container, Nav, Navbar} from "react-bootstrap";


function Navigation(){
    return(
        <>
            <Navbar bg="primary" variant="dark">
                <Container>
                    <Navbar.Brand href="/App">Home</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/login">Login</Nav.Link>
                        <Nav.Link href="/register">Register</Nav.Link>
                        <Nav.Link href="/forgotPw">ForgotPassword</Nav.Link>
                        <Nav.Link href="/create-board">create board</Nav.Link>
                        <Nav.Link href="/boards">create board</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
    );
}

export default Navigation;