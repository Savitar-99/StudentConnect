import React, { useState } from 'react';
import { Container, TextField, Button, Typography, Box, Link } from '@mui/material';
import backgroundVideo from '../assets/video.mp4'; // Asegúrate de que la ruta sea correcta
import logo from '../assets/logo.png'; // Ruta del logo

const Login: React.FC = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    console.log(`Email: ${email}, Password: ${password}`);
  };

  return (
    <Box sx={{ display: 'flex', height: '100vh', overflow: 'hidden' }}> {/* Desactivar el scroll */}
      {/* Video de fondo */}
      <Box
        sx={{
          position: 'absolute',
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
            objectFit: 'cover',
            width: '100%',
            height: '100%',
            position: 'absolute',
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
          }}
        >
          <source src={backgroundVideo} type="video/mp4" />
        </video>
      </Box>

      {/* Contenedor del formulario, alineado al lado izquierdo */}
      <Container
        maxWidth="xs"
        sx={{
          display: 'flex',
          flexDirection: 'column',
          justifyContent: 'start',
          alignItems: 'flex-start',
          backgroundColor: 'rgba(0, 0, 0, 0.8)', // Fondo más oscuro
          padding: '20px',
          zIndex: 1,
          marginLeft: '100px',
          height: '100%',
          borderLeft: '2px solid #F26F63', // Borde añadido
          borderRight: '2px solid #F26F63', // Borde añadido
        }}
      >
        {/* Logo encima */}
        <Box sx={{ textAlign: 'center', marginBottom: '1px' }}>
          <img src={logo} alt="Logo" style={{ width: '300px', marginLeft: '50px', marginRight: '40' }} />
        </Box>
        <Typography variant="h5" sx={{ color: '#fff', marginBottom: '20px', textAlign: 'left' }}>
          Iniciar Sesión
        </Typography>
        <form onSubmit={handleLogin}>
          {/* Campo de Email */}
          <TextField
            label="Correo Electrónico"
            type="email"
            fullWidth
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            sx={{
              marginBottom: '20px',
              '& .MuiOutlinedInput-root': {
                '& fieldset': {
                  borderColor: '#F26F63',  // Color del borde
                },
                '&:hover fieldset': {
                  borderColor: '#e74c3c',  // Color del borde al pasar el mouse
                },
                '&.Mui-focused fieldset': {
                  borderColor: '#FF5733',  // Color del borde cuando el campo está enfocado
                },
              },
              '& input': {
                color: '#fff',  // Color del texto dentro del input
              },
            }}
            InputLabelProps={{
              style: { color: '#fff' }, // Color de la etiqueta
            }}
          />
          {/* Campo de Contraseña */}
          <TextField
            label="Contraseña"
            type="password"
            fullWidth
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            sx={{
              marginBottom: '20px',
              '& .MuiOutlinedInput-root': {
                '& fieldset': {
                  borderColor: '#F26F63',  // Color del borde
                },
                '&:hover fieldset': {
                  borderColor: '#e74c3c',  // Color del borde al pasar el mouse
                },
                '&.Mui-focused fieldset': {
                  borderColor: '#FF5733',  // Color del borde cuando el campo está enfocado
                },
              },
              '& input': {
                color: '#fff',  // Color del texto dentro del input
              },
            }}
            InputLabelProps={{
              style: { color: '#fff' }, // Color de la etiqueta
            }}
          />
          {/* Botón de Login */}
          <Button
            type="submit"
            variant="contained"
            fullWidth
            sx={{
              backgroundColor: '#F26F63',
              '&:hover': {
                backgroundColor: '#e74c3c',
              },
            }}
          >
            Entrar
          </Button>
        </form>

        {/* Mensaje para registrarse o recuperar contraseña */}
        <Box sx={{ marginTop: '20px', color: '#fff' }}>
          <Typography variant="body2">
            ¿No tienes cuenta?{' '}
            <Link href="/registro" sx={{ color: '#F26F63', textDecoration: 'none' }}>
              Regístrate
            </Link>
          </Typography>
          <Typography variant="body2" sx={{ marginTop: '10px' }}>
            ¿Has olvidado tu contraseña?{' '}
            <Link href="/recuperar-contraseña" sx={{ color: '#F26F63', textDecoration: 'none' }}>
              Recupérala
            </Link>
          </Typography>
        </Box>
      </Container>
    </Box>
  );
};

export default Login;
