import React from 'react'
import TuneIcon from '@mui/icons-material/Tune';
import { ISearchInputs } from './ISearch';

const SearchFiltersIcon = (props: ISearchInputs) => {
    
    const { 
      open, 
      setOpen, 
      isClicked, 
      setIsClicked 
    } = props;

    const handleClick = () => {
      setOpen(!open);
      setIsClicked(!isClicked);
    }

  return (
    <div className='absolute h-16 w-[100%] flex justify-end items-center z-10 lg:hidden'>
        <i>
            <TuneIcon
            fontSize='large'
            className='mr-5 cursor-pointer'
            onClick={handleClick}
            />
        </i>
    </div>
  )
}

export default SearchFiltersIcon