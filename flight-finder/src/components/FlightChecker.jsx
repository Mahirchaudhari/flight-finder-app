import { useState } from "react";
import "./FlightChecker.css";
import { checkFlightCount } from "./FlightCheckerAPI";

function FlightChecker() {
  const [input, setInput] = useState("");
  const [count, setCount] = useState(null);
  const [error, setError] = useState(null);

  const handleCheck = async () => {
    setCount(null);
    setError(null);

    if (/^[a-z\s]*$/.test(input)) {
      try {
        const response = await checkFlightCount(input);
        const data = await response.json();
        if (response.ok) {
          setCount(data.count);
        } else {
          setError(data.inputKeyword || "Error occurred");
        }
      } catch (err) {
        setError("Network error");
      }
    } else {
      setError("Only lowercase letters (a-z) are allowed.");
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
