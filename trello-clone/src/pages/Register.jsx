import React, { useEffect, useState } from "react";
import styles from "../styles/signup.module.css";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";

const { REACT_APP_API_URL } = process.env;

const Signup = (props) => {
  const [values, setValues] = useState({
    email: "",
    password: "",
    firstName: "",
    lastName: "",
    dateOfBirth: "",
    phoneNumber: "",
    confirmPassword: "",
    loginType: "User",
    restaurantName: "",
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    if (location?.state?.message) {
      setError(location?.state?.message);
    }
  }, []);

  const handleChange = (e) =>
    setValues({ ...values, [e.target.name]: e.target.value });

  const handleSubmit = (event) => {
    event.preventDefault();
    if (
      !values.password ||
      !values.firstName ||
      !values.email ||
      !values.loginType
    ) {
      setError("Email, first name and password are mandatory to fill!");
      return;
    }
    if (values.password !== values.confirmPassword) {
      setError("Password and confirm password should match!");
      return;
    }
    if (values.loginType === "Restaurant" && !values.restaurantName) {
      setError("Restaurant name is required for this user type.");
      return;
    }
    let data = { ...values };
    delete data.confirmPassword;
    setLoading(true);
    axios
      .post(`${REACT_APP_API_URL}/api/registration/signup`, data)
      .then((res) => {
        setLoading(false);
        setError("");
        if (res.data.status) {
          localStorage.setItem("profile", JSON.stringify(res.data.data));
          if (res.data.data.loginType === "User") {
            navigate("/home");
          } else {
            navigate("/organization_home");
          }
        } else {
          setLoading(false);
          setError(res?.data?.message);
        }
      })
      .catch((err) => {
        setLoading(false);
        setError(err?.response?.data?.message || "Something went wrong.");
      });
  };

  return (
    <div>
      <div className={styles.siteHeader}>
        <div>
          <img className={styles.logo} src={Image} alt="Logo" />
        </div>
      </div>
      <div className={styles.signupContainer}>
        <div className={styles.form}>
          <div className={styles.title}>
            <h3>Sign Up</h3>
          </div>
          {error && <p className={styles.errorMessage}>{error}</p>}
          <div className={styles.structure}>
            <div>
              First Name
              <br />
              <input
                type="text"
                name="firstName"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
            <div>
              Last Name
              <br />
              <input
                type="text"
                name="lastName"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
            <div>
              Email
              <br />
              <input
                type="text"
                name="email"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
            <div>
              Date of birth
              <br />
              <input
                type="text"
                name="dateOfBirth"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
            <div>
              Phone number
              <br />
              <input
                type="text"
                name="phoneNumber"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
            <div>
              User type
              <br />
              <select
                name="loginType"
                className={`form-control ${styles.input} ${styles.select}`}
                onChange={handleChange}
              >
                <option value="User">User</option>
                <option value="Restaurant">Restaurant</option>
              </select>
            </div>
            {values.loginType === "Restaurant" && (
              <>
                <div>
                  Restaurant name
                  <br />
                  <input
                    type="text"
                    name="restaurantName"
                    className={styles.input}
                    onChange={handleChange}
                  />
                </div>
                <div />
              </>
            )}
            <div>
              Password
              <br />
              <input
                type="password"
                name="password"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
            <div>
              Confirm password
              <br />
              <input
                type="password"
                name="confirmPassword"
                className={styles.input}
                onChange={handleChange}
              />
            </div>
          </div>
          <br />
          <div className="w-100 text-center">
            <input type="checkbox" className="w-auto" id={`id`} name={`name`} />
            &nbsp; <label for={`id`}>I agree to the site's <Link to="/privacy">privacy policy</Link>.</label>
          </div>
          <br />
          <div className={styles.submitContainer}>
            <button
              className={styles.signUpButton}
              onClick={handleSubmit}
              disabled={loading}
            >
              Sign in
            </button>
          </div>
          <br />
          <div style={{ textAlign: "center" }}>
            Already joined us? <Link to="/login">Login here.</Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Signup;
