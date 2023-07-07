import useAxiosPrivate from "@/hooks/useAxiosPrivate";
import { useEffect, useState } from "react";

const useFindKeywords = () => {
    const axiosPrivate = useAxiosPrivate();
    const [keywords, setKeywords] = useState([]);
    useEffect(() => {
        const findKeywords = async () => {
            try {
                const response = await axiosPrivate.get('/api/keyword');
                setKeywords(response.data);
            }
            catch(error) {
                console.error(error);
            }
        }
        findKeywords();
    }, [axiosPrivate])
    return { keywords }
}

export default useFindKeywords;