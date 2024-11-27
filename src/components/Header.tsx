import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Header.css';
import logo from '../assets/logodefault.png'; // Ruta correcta de la imagen

const Header: React.FC = () => {
  const navigate = useNavigate(); // Hook para redirección

  // Función para cerrar sesión
  const handleLogout = () => {
    localStorage.removeItem('user'); // Elimina el usuario del localStorage
    navigate('/login'); // Redirige al login
  };

  // Verifica si el usuario está autenticado
  const isAuthenticated = localStorage.getItem('user') !== null;

  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-danger">
      <div className="container">
        {/* Logo de la web en pequeñito */}
        <Link className="navbar-brand text-white" to="/">
        <img src="/logodefault.png" alt="Logo" className="navbar-logo" />
          StudentConnect
        </Link>
        <div className="d-flex">
          {!isAuthenticated ? (
            // Mostrar solo el enlace de login si no está autenticado
            <Link className="nav-link text-white" to="/login">
              Login
            </Link>
          ) : (
            // Mostrar el botón de logout si está autenticado
            <button className="btn btn-outline-light" onClick={handleLogout}>
              Logout
            </button>
          )}
        </div>
      </div>
    </nav>
  );
};

export default Header;
