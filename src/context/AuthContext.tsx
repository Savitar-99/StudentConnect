import React, { createContext, useContext, useState } from "react";

// Tipos para el usuario
type User = {
  email: string;
  role: "teacher" | "student";
};

type AuthContextType = {
  user: User | null;
  login: (email: string, password: string) => boolean;
  logout: () => void;
};

const AuthContext = createContext<AuthContextType | null>(null);

export const AuthProvider = ({ children }: { children: React.ReactNode }) => {
  const [user, setUser] = useState<User | null>(null);

  // Simular usuarios (esto se reemplaza con una API en el futuro)
  const users: ReadonlyArray<{ email: string; password: string; role: "teacher" | "student" }> = [
    { email: "teacher@example.com", password: "1234", role: "teacher" },
    { email: "student@example.com", password: "5678", role: "student" },
  ];

  const login = (email: string, password: string): boolean => {
    const foundUser = users.find(
      (u) => u.email === email && u.password === password
    );
    if (foundUser) {
      setUser({ email: foundUser.email, role: foundUser.role });
      return true;
    }
    return false;
  };

  const logout = () => {
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("useAuth debe ser usado dentro de AuthProvider");
  }
  return context;
};
