const BASE_URL = "http://localhost:8081";

export const checkFlightCount = (input) => {
  return fetch(`${BASE_URL}/api/flights/search`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ inputKeyword: input }),
  });
};
