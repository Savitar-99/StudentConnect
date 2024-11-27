import React from 'react';
import { Link } from 'react-router-dom';

const Home: React.FC = () => {
  return (
    <div className="text-center mt-5">
      <h1>Bienvenido a StudentConnect</h1>
      <p>Gestiona de manera eficiente la asistencia y valoración académica.</p>
      <Link to="/login" className="btn btn-primary">
        Empezar
      </Link>
    </div>
  );
};

export default Home;
