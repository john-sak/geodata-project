import React, { useEffect, useState } from 'react'
import { ISearchInputProps, ISearchInputs, ISearchRadius } from './ISearch'
import SearchInput from './SearchInput';
import SearchName from './SearchName';
import SearchRadius from './SearchRadius';

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

    useEffect(() => {
        console.log(searchData);
        const buidlingTypeList = searchData.buildingType.split(',');
        console.log('buidlingTypeList', buidlingTypeList);
        const keywordList = searchData.keyword.split(',');
        console.log('keywordList', keywordList);
    }, [searchData])

    const freeTextInput: ISearchInputProps = {
        data: data,
        value: freeText,
        name: 'freeText',
        label: 'Ελεύθερη Αναζήτηση'
    }

    const buidlingTypeInput: ISearchInputProps = {
        data: data,
        value: buildingType,
        name: 'buildingType',
        label: 'Τύπος Κτιρίου'
    }

    const keywordInput: ISearchInputProps = {
        data: data,
        value: keyword,
        name: 'keyword',
        label: 'Κατηγορίες'
    }

  return (
    <>
        {
            open &&
            <div className='h-[100%] w-[100%] bg-sky-800 border-4 border-orange-300 flex flex-col lg:w-[30%] xl:w-[25%] 2xl:w-[20%]'>
                <div className='w-[100%] h-[100%] flex flex-col mt-16 last:mb-4 lg:mt-0'>
                    { !showMap && <SearchInput {...freeTextInput}/> }
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