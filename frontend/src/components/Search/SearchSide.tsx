import React, { useEffect, useState } from 'react'
import { ISearchInputProps, ISearchInputs, ISearchRadius } from './ISearch'
import SearchInput from './SearchInput';
import SearchName from './SearchName';
import SearchRadius from './SearchRadius';

const SearchSide = (props: ISearchInputs) => {

    const {
        open,
        data,
        radius
    } = props;
    const { searchData } = data;
    const {
        buildingType,
        county,
        region
    } = searchData;

    useEffect(() => {
        console.log(searchData);
    }, [searchData])

    const buidlingTypeInput: ISearchInputProps = {
        data: data,
        value: buildingType,
        name: 'buildingType',
        label: 'Τύπος κτιρίου'
    }

    const countyInput: ISearchInputProps = {
        data: data,
        value: county,
        name: 'county',
        label: 'Νομός'
    }

    const regionInput: ISearchInputProps = {
        data: data,
        value: region,
        name: 'region',
        label: 'Περιφέρεια'
    }

  return (
    <>
        {
            open &&
            <div className='h-[100%] w-[100%] bg-sky-800 border-4 border-orange-300 flex flex-col lg:w-[30%] xl:w-[25%] 2xl:w-[20%]'>
                <div className='w-[100%] h-[100%] flex flex-col mt-16 last:mb-4 lg:mt-0'>
                    <SearchInput {...buidlingTypeInput}/>
                    <SearchInput {...countyInput}/>
                    <SearchInput {...regionInput}/>
                    <SearchName/>
                    <SearchRadius {...radius}/>
                </div>
            </div>
        }
    </>
    
  )
}

export default SearchSide