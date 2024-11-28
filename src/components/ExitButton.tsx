import React from "react";
import { useNavigate } from "react-router-dom";
import { Button } from "@mui/material";

const ExitButton = () => {
  const navigate = useNavigate();

  const handleExit = () => {
    navigate("/"); // Redirige al menú principal
  };

  return (
    <Button
      variant="contained"
      color="secondary"
      onClick={handleExit}
      sx={{
        position: "fixed",
        top: 20,
        right: 20,
        zIndex: 1000,
      }}
    >
      Salir
    </Button>
  );
};

export default ExitButton;
