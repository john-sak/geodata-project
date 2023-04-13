import React from 'react'
import MenuIcon from '@mui/icons-material/Menu';
import CloseIcon from '@mui/icons-material/Close';
import { INavMenu } from './Inav';

const NavIcon = (props: INavMenu) => {

    const { open, setOpen } = props;

  return (
    <>
        {
        open ? 
          <CloseIcon className='absolute right-5 z-10 lg:hidden cursor-pointer'
          fontSize='large'
          onClick={() => setOpen(!open)}
          /> :
          <MenuIcon className='absolute right-5 z-10 lg:hidden cursor-pointer'
          fontSize='large'
          onClick={() => setOpen(!open)}
          />
      }
    </>
  )
}

export default NavIcon