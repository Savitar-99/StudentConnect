// src/components/Home.tsx

import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css'; // Importar el archivo CSS para los estilos

const Home: React.FC = () => {
  return (
    <div className="home-container">
      {/* Video de fondo */}
      <div className="video-container">
        <video autoPlay loop muted>
          <source src="/video1.mp4" type="video/mp4" />
          Tu navegador no soporta la etiqueta de video.
        </video>
      </div>

      {/* Capa de bienvenida y logo */}
      <div className="welcome-overlay">
        <h1 className="welcome-text">Bienvenido a StudentConnect</h1>
        <p className="welcome-subtext">Gestiona de manera eficiente la asistencia y valoración académica.</p>

        {/* Logo debajo del texto */}
        <img src="/logodefault.png" alt="Logo" className="logo" />
      </div>
    </div>
  );
};

export default Home;
