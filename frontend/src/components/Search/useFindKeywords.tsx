import { useEffect, useState } from "react";
import axios from "@/api/axios";

const useFindKeywords = () => {
    const [keywords, setKeywords] = useState([]);
    useEffect(() => {
        const findKeywords = async () => {
            try {
                const response = await axios.get('/api/keyword');
                setKeywords(response.data);
            }
            catch(error) {
                console.error(error);
            }
        }
        findKeywords();
    }, [])
    return { keywords }
}

export default useFindKeywords;