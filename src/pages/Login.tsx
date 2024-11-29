import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { Container, TextField, Button, Typography, Box, Link } from "@mui/material";
import backgroundVideo from "../assets/video.mp4";
import logo from "../assets/logo.png";
import "./Login.css"; // Asegúrate de importar tu archivo CSS

const Login: React.FC = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [animationClass, setAnimationClass] = useState(""); // Controla la animación
  const navigate = useNavigate();
  const { login, user } = useAuth(); // Obtén las funciones de login y el usuario

  useEffect(() => {
    setAnimationClass("fadeIn"); // Activa la animación al cargar
  }, []);

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    const success = login(email, password); // Valida credenciales
    if (success) {
      // Usa una variable local para garantizar que el rol esté actualizado
      const userRole = user?.role;
      if (userRole === "teacher") {
        navigate("/teacher");
      } else if (userRole === "student") {
        navigate("/student");
      } else {
        alert("Error inesperado: Rol desconocido.");
      }
    } else {
      alert("Credenciales inválidas. Por favor, inténtalo de nuevo.");
    }
  };

  return (
    <Box sx={{ display: "flex", height: "100vh", overflow: "hidden" }}>
      {/* Video de fondo */}
      <Box
        sx={{
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          zIndex: -1,
        }}
      >
        <video
          autoPlay
          loop
          muted
          style={{
            objectFit: "cover",
            width: "100%",
            height: "100%",
            position: "absolute",
            top: "50%",
            left: "50%",
            transform: "translate(-50%, -50%)",
          }}
        >
          <source src={backgroundVideo} type="video/mp4" />
        </video>
      </Box>

      {/* Contenedor del formulario */}
      <Container
        maxWidth="xs"
        className={animationClass} // Añadimos la clase animada
        sx={{
          display: "flex",
          flexDirection: "column",
          justifyContent: "start",
          alignItems: "flex-start",
          backgroundColor: "rgba(0, 0, 0, 0.8)",
          padding: "20px",
          zIndex: 1,
          marginLeft: "100px",
          height: "100%",
          borderLeft: "2px solid #F26F63",
          borderRight: "2px solid #F26F63",
        }}
      >
        {/* Logo */}
        <Box
          className={animationClass} // Animación también para el logo
          sx={{ textAlign: "center", marginBottom: "1px" }}
        >
          <img src={logo} alt="Logo" style={{ width: "300px", marginLeft: "50px" }} />
        </Box>
        <Typography variant="h5" sx={{ color: "#fff", marginBottom: "20px", textAlign: "left" }}>
          Iniciar Sesión
        </Typography>
        <form onSubmit={handleLogin}>
          <TextField
            label="Correo Electrónico"
            type="email"
            fullWidth
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            sx={{
              marginBottom: "20px",
              "& .MuiOutlinedInput-root": {
                "& fieldset": {
                  borderColor: "#F26F63",
                },
                "&:hover fieldset": {
                  borderColor: "#e74c3c",
                },
                "&.Mui-focused fieldset": {
                  borderColor: "#FF5733",
                },
              },
              "& input": {
                color: "#fff",
              },
            }}
            InputLabelProps={{
              style: { color: "#fff" },
            }}
          />
          <TextField
            label="Contraseña"
            type="password"
            fullWidth
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            sx={{
              marginBottom: "20px",
              "& .MuiOutlinedInput-root": {
                "& fieldset": {
                  borderColor: "#F26F63",
                },
                "&:hover fieldset": {
                  borderColor: "#e74c3c",
                },
                "&.Mui-focused fieldset": {
                  borderColor: "#FF5733",
                },
              },
              "& input": {
                color: "#fff",
              },
            }}
            InputLabelProps={{
              style: { color: "#fff" },
            }}
          />
          <Button
            type="submit"
            variant="contained"
            fullWidth
            sx={{
              backgroundColor: "#F26F63",
              "&:hover": {
                backgroundColor: "#e74c3c",
              },
            }}
          >
            Entrar
          </Button>
        </form>
        <Box sx={{ marginTop: "20px", color: "#fff" }}>
          <Typography variant="body2">
            ¿No tienes cuenta?{" "}
            <Link href="/registro" sx={{ color: "#F26F63", textDecoration: "none" }}>
              Regístrate
            </Link>
          </Typography>
          <Typography variant="body2" sx={{ marginTop: "10px" }}>
            ¿Has olvidado tu contraseña?{" "}
            <Link href="/recuperar-contraseña" sx={{ color: "#F26F63", textDecoration: "none" }}>
              Recupérala
            </Link>
          </Typography>
        </Box>
      </Container>
    </Box>
  );
};

export default Login;
