import React, { useState } from 'react'
import SearchSide from './SearchSide'
import SearchFiltersIcon from './SearchFiltersIcon'
import { ISearchFilter, ISearchValue } from './ISearch'
import useFilter from './useFilter'

const Search = (props: ISearchValue) => {

    const { value, setValue } = props;

    const { openFilter, setOpenFilter } = useFilter();

    const searchFilter: ISearchFilter = {
        open: openFilter,
        setOpen: setOpenFilter,
        value: value,
        setValue: setValue
    }

  return (
    <>
        <div className='relative h-[800px] w-[100%] bg-sky-400 flex flex-row z-0'>
            <SearchFiltersIcon {...searchFilter}/>
            <SearchSide {...searchFilter}/>
        </div>
        {
          openFilter && 
            <div className='h-[300px] w-[100%] bg-red-900'>

            </div>
        }
        
    </>
    
  )
}

export default Search