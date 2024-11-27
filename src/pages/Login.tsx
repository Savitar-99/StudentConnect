import React, { useState } from 'react';
import axios from 'axios'; // Asegúrate de que axios esté instalado
import { useNavigate } from 'react-router-dom';

const Login: React.FC = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState(''); // Manejo de errores
  const navigate = useNavigate();

  // Configuración de la instancia de Axios
  const axiosInstance = axios.create({
    baseURL: 'http://localhost:5000', // Asegúrate de que tu JSON Server esté corriendo en este puerto
  });

  const handleLogin = async () => {
    try {
      // Validación básica
      if (!email || !password) {
        setErrorMessage('Por favor, completa todos los campos.');
        return;
      }

      // Obtén los usuarios desde el JSON Server
      const response = await axiosInstance.get('/users', {
        params: { email, password }, // Filtra por email y contraseña
      });

      const user = response.data[0]; // Obtiene el primer usuario que coincida

      if (user) {
        // Guarda el usuario en el localStorage
        localStorage.setItem('user', JSON.stringify(user));
        navigate('/dashboard'); // Redirige al dashboard
      } else {
        setErrorMessage('Credenciales incorrectas. Por favor, inténtalo de nuevo.');
      }
    } catch (error) {
      console.error('Error al iniciar sesión:', error);
      setErrorMessage('Hubo un problema al iniciar sesión. Inténtalo de nuevo más tarde.');
    }
  };

  return (
    <div className="container mt-5">
      <h2>Iniciar Sesión</h2>
      {errorMessage && <div className="alert alert-danger">{errorMessage}</div>} {/* Mensaje de error */}
      <div className="form-group">
        <label>Email:</label>
        <input
          type="email"
          className="form-control"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>
      <div className="form-group">
        <label>Contraseña:</label>
        <input
          type="password"
          className="form-control"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <button className="btn btn-primary mt-3" onClick={handleLogin}>
        Iniciar Sesión
      </button>
    </div>
  );
};

export default Login;
