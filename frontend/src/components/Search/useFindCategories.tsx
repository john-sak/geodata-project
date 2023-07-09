import { useEffect, useState } from "react";
import axios from "@/api/axios";

interface ICategories {
    id: number,
    name: string
}

const useFindCategories = () => {
    const [categories, setCategories] = useState<ICategories[]>([]);
    useEffect(() => {
        const findCategories = async () => {
            try {
                const response = await axios.get('/api/categories');
                setCategories(response.data);
            }
            catch(error) {
                console.error(error);
            }
        }
        findCategories();
    }, [])
    return { categories }
}

export default useFindCategories;