import React from 'react';
import { Navigate } from 'react-router-dom';

interface ProtectedRouteProps {
  children: JSX.Element;
}

const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ children }) => {
  const user = localStorage.getItem('user');

  // Si no hay usuario, redirige al login
  if (!user) {
    return <Navigate to="/login" />;
  }

  return children; // Si hay usuario, renderiza la ruta protegida
};

export default ProtectedRoute;
