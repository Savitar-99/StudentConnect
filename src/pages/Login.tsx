import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import {
  Box,
  TextField,
  Button,
  Typography,
  Grid,
  Paper,
} from "@mui/material";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleLogin = () => {
    const success = login(email, password);
    if (success) {
      navigate(email === "teacher@example.com" ? "/teacher" : "/student");
    } else {
      setError("Credenciales inválidas. Intenta de nuevo.");
    }
  };

  return (
    <Grid
      container
      component="main"
      sx={{ height: "100vh", backgroundColor: "#f5f5f5" }}
    >
      <Grid
        item
        xs={12}
        sm={8}
        md={5}
        component={Paper}
        elevation={6}
        square
        sx={{
          display: "flex",
          flexDirection: "column",
          justifyContent: "center",
          alignItems: "center",
          p: 4,
        }}
      >
        <Typography variant="h4" component="h1" gutterBottom>
          Bienvenido a StudentConnect
        </Typography>
        <Box
          component="form"
          sx={{
            mt: 1,
            display: "flex",
            flexDirection: "column",
            gap: 2,
            width: "100%",
          }}
          noValidate
        >
          <TextField
            variant="outlined"
            label="Correo Electrónico"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            fullWidth
          />
          <TextField
            variant="outlined"
            label="Contraseña"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            fullWidth
          />
          {error && (
            <Typography color="error" variant="body2">
              {error}
            </Typography>
          )}
          <Button
            variant="contained"
            color="primary"
            size="large"
            onClick={handleLogin}
            fullWidth
          >
            Iniciar Sesión
          </Button>
        </Box>
      </Grid>
    </Grid>
  );
};

export default Login;
