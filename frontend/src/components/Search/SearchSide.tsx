import React, { useEffect, useState } from 'react'
import { ISearchInputProps, ISearchInputs, ISearchRadius, ISearchFreeTextInputProps } from './ISearch'
import SearchInput from './SearchInput';
import SearchName from './SearchName';
import SearchRadius from './SearchRadius';
import SearchSideFreeText from './SearchSideFreeText';
import useAxiosPrivate from '@/hooks/useAxiosPrivate';
import useFindKeywords from './useFindKeywords';
import useFindCategories from './useFindCategories';

const SearchSide = (props: ISearchInputs) => {

    const {
        open,
        data,
        radius,
        showMap
    } = props;
    const { searchData } = data;
    const {
        freeText,
        buildingType,
        keyword
    } = searchData;

    const axiosPrivate = useAxiosPrivate();
    const { keywords } = useFindKeywords();
    console.log(keywords);
    const { categories } = useFindCategories();
    console.log(categories);

    useEffect(() => {
        console.log(searchData);
        console.log('freeText', searchData.freeText);
        const buidlingTypeList = searchData.buildingType.split(',');
        // console.log('buidlingTypeList', buidlingTypeList);
        const filteredObjects = categories.filter(obj => buidlingTypeList.includes(obj.name));
        const idBuildingTypeList = filteredObjects.map(obj => obj.id);
        console.log('idBuildingTypeList', idBuildingTypeList);
        const keywordList = searchData.keyword.split(',');
        console.log('keywordList', keywordList);
        // const fun = async () => {
        //     const dat = {
        //         "start": 0,
        //         "count": 1,
        //         "text": null,
        //         "filters": {
        //             "distance": {
        //                 "lat": 38.27056885,
        //                 "lon": 21.74781227,
        //                 "km": 1
        //             },
        //             "keywords": [],
        //             "categories": []
        //         }
        //     }
        //     try {
        //         const response = await axiosPrivate.post('/api/poi/search', dat);
        //         console.log(response.data);
        //     }
        //     catch(error) {
        //         console.error(error);
        //     }
        // }
        // fun();
    }, [searchData])

    const freeTextInput: ISearchFreeTextInputProps = {
        data: data,
        value: freeText,
        name: 'freeText',
        label: 'Ελεύθερη Αναζήτηση'
    }

    // Building types are db's categories and want to return the ids
    const buidlingTypeInput: ISearchInputProps = {
        data: data,
        value: buildingType,
        name: 'buildingType',
        label: 'Τύπος Κτιρίου',
        dataList: categories
    }

    // Categories are db's keywords and want to return the names
    const keywordInput: ISearchInputProps = {
        data: data,
        value: keyword,
        name: 'keyword',
        label: 'Κατηγορίες',
        dataList: categories
    }

  return (
    <>
        {
            open &&
            <div className='h-[100%] w-[100%] bg-sky-800 border-4 border-orange-300 flex flex-col lg:w-[30%] xl:w-[25%] 2xl:w-[20%]'>
                <div className='w-[100%] h-[100%] flex flex-col mt-16 last:mb-4 lg:mt-0'>
                    { !showMap && <SearchSideFreeText {...freeTextInput}/> }
                    <SearchInput {...buidlingTypeInput}/>
                    <SearchInput {...keywordInput}/>
                    <SearchName/>
                    <SearchRadius {...radius}/>
                </div>
            </div>
        }
    </>
    
  )
}

export default SearchSide