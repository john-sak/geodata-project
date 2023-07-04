import { useState, useEffect } from "react";

const useLogged = () => {
    const [isLogged, setIsLogged] = useState(false);

    useEffect(() => {
        const access = localStorage.getItem('access_token');
        if(access) {
            setIsLogged(true);
        }
        else {
            setIsLogged(false);
        }
    })

    return { isLogged, setIsLogged }
}

export default useLogged;