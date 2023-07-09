import { useEffect, useState } from 'react'
import { IPoiResult, ISearchData } from './ISearch';
import useFindCategories from './useFindCategories';
import axios from '@/api/axios';

const useFindResults = (props: ISearchData) => {
    const { searchData, location } = props;
    const {
        freeText,
        buildingType,
        keyword
    } = searchData;
    const { numbers } = location;
    const [results, setResults] = useState<IPoiResult[]>([]);
    const { categories } = useFindCategories();

    useEffect(() => {
        const findResults = async () => {
            const buidlingTypeList = buildingType.split(',');
            const filteredObjects = categories.filter(obj => buidlingTypeList.includes(obj.name));
            const idBuildingTypeList = filteredObjects.map(obj => obj.id.toString());
            const keywordList = keyword.split(',');
            try {
                const data = {
                    start: 0,
                    count: 1,
                    text: freeText,
                    filters: {
                        distance: {
                            lat: numbers.lat,
                            lon: numbers.lon,
                            km: numbers.radius
                        },
                        keywords: keywordList[0] === "" ? [] : keywordList,
                        categories: idBuildingTypeList[0] === "" ? [] : idBuildingTypeList
                    }
                }
                console.log(data);
                const response = await axios.post('/api/poi/search', data);
                setResults(response.data.data);
            }
            catch(error) {
                console.error(error);
            }
        }
        findResults();
    }, [searchData, numbers])

    return { results }
}

export default useFindResults