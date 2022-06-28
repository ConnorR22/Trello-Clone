import React, { useState } from "react";
import styles from "../styles/login.module.css";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const { REACT_APP_API_URL } = process.env

const Login = (props) => {
  const [values, setValues] = useState({
    email: "", password: ""
  })
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState("")
  const navigate = useNavigate()

  const handleChange = e => setValues({ ...values, [e.target.name]: e.target.value })

  const handleSubmit = () => {
    if(!values.email || !values.password) {
      setError("Please enter email and password to login.")
      return
    }
    setLoading(true)
    axios.post(`${REACT_APP_API_URL}/api/registration/login`, values).then(res => {
      setLoading(false)
      setError("")
      if(res.data.status) {
        localStorage.setItem("profile", JSON.stringify(res.data.data))
        if(res.data.data.loginType === "User") {
          navigate("/home")
        } else {
          navigate("/organization_home")
        }
      } else {
        setLoading(false)
        setError(res?.data?.message)
      }
    }).catch(err => {
      setLoading(false)
      setError(err?.response?.data?.message || "Something went wrong.")
    })
  }

  return (
    <div>
    <div className={styles.siteHeader}>
    <div className={styles.signinContainer}>

<div className={styles.form}>
<div className={styles.title}><h3>Login</h3></div>
{error && <p className={styles.errorMessage}>{error}</p>}
        <div>
        <input type="text" name="email" placeholder="Email" className={styles.input} onChange={handleChange} />
        </div>
        <div>
          <input type="password" name="password" placeholder="Password" className={styles.input} onChange={handleChange} />
          <div className={styles.submitContainer}>
          <button className={styles.signinButton} onClick={handleSubmit} disabled={loading}>Sign in</button>
        </div>
        <br />
        <div style={{ textAlign: 'center' }}>Not a member? <Link to="/signup">Signup here.</Link></div>
        </div>
      </div>
      </div>
      </div>
    </div>
  );
};

export default Login;
