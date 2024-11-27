import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Dashboard: React.FC = () => {
  const [userRole, setUserRole] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    // Verifica si hay un usuario en el localStorage
    const storedUser = localStorage.getItem('user');
    if (!storedUser) {
      navigate('/login'); // Si no hay usuario, redirige al login
    } else {
      const user = JSON.parse(storedUser); // Convierte el JSON a objeto
      setUserRole(user.role); // Guarda el rol del usuario
    }
  }, [navigate]);

  return (
    <div className="container mt-5">
      <h1>Dashboard</h1>
      <p>Bienvenido, tu rol es: <strong>{userRole}</strong></p>

      {/* Opciones según el rol */}
      {userRole === 'admin' && <p>Opciones para Administrador</p>}
      {userRole === 'profesor' && <p>Opciones para Profesor</p>}
      {userRole === 'estudiante' && <p>Opciones para Estudiante</p>}
    </div>
  );
};

export default Dashboard;
