import useAxiosPrivate from "@/hooks/useAxiosPrivate";
import { useEffect, useState } from "react";

interface ICategories {
    id: number,
    name: string
}

const useFindCategories = () => {
    const axiosPrivate = useAxiosPrivate();
    const [categories, setCategories] = useState<ICategories[]>([]);
    useEffect(() => {
        const findCategories = async () => {
            try {
                const response = await axiosPrivate.get('/api/categories');
                setCategories(response.data);
            }
            catch(error) {
                console.error(error);
            }
        }
        findCategories();
    }, [axiosPrivate])
    return { categories }
}

export default useFindCategories;