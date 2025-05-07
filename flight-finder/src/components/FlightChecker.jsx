import { useState } from "react";
import "./FlightChecker.css";

function FlightChecker() {
  const [input, setInput] = useState("");
  const [count, setCount] = useState(null);
  const [error, setError] = useState(null);

  const handleCheck = async () => {
    setCount(null);
    setError(null);

    try {
      const response = await fetch("http://localhost:8081/api/flights/search", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ inputKeyword: input }),
      });

      const data = await response.json();

      if (response.ok) {
        setCount(data.count);
      } else {
        setError(data.inputKeyword || "Error occurred");
      }
    } catch (err) {
      setError("Network error");
    }
  };

  return (
    <div className="container">
      <h1>✈️ Flight Word Counter</h1>
      <input
        type="text"
        placeholder="Enter text here..."
        value={input}
        onChange={(e) => setInput(e.target.value)}
      />
      <button onClick={handleCheck}>Check</button>

      {count !== null && (
        <p className="result">
          ✅ The word 'flight' can be formed <strong>{count}</strong> time(s).
        </p>
      )}

      {error && <p className="error">⚠️ {error}</p>}
    </div>
  );
}

export default FlightChecker;
