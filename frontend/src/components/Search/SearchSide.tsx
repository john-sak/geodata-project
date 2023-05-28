import React, { useEffect } from 'react'
import { ISearchInputProps, ISearchInputs } from './ISearch'
import SearchInput from './SearchInput';

const SearchSide = (props: ISearchInputs) => {

    const { open, data } = props;
    const { searchData } = data;
    const {
        buildingType,
        municipality,
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

    const municipalityInput: ISearchInputProps = {
        data: data,
        value: municipality,
        name: 'municipality',
        label: 'Δήμος'
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
            <div className='h-[100%] w-full bg-red-500 flex flex-col lg:w-[30%] xl:w-[25%] 2xl:w-[20%]'>
                <div className='w-[100%] h-[100%] flex flex-col mt-16 last:mb-4 lg:mt-0'>
                    <SearchInput {...buidlingTypeInput}/>
                    <SearchInput {...municipalityInput}/>
                    <SearchInput {...countyInput}/>
                    <SearchInput {...regionInput}/>
                </div>
            </div>
        }
    </>
    
  )
}

export default SearchSide