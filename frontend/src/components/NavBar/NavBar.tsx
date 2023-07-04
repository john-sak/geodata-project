import React, {useState} from 'react'
import NavLogo from './NavLogo'
import NavMenu from './NavMenu';
import NavIcon from './NavIcon';
import { INavLink, INavMenu } from './Inav';
import NavLink from './NavLink';
import NavButtons from './NavButtons';
import { INavMenuProps } from './Inav';
import useLogged from './useLogged';
import NavBarAccount from './NavBarAccount';

const NavBar = (props: INavMenuProps) => {

  const  { menuColor } = props;

  console.log(menuColor);

  const [open, setOpen] = useState(false);

  const { isLogged } = useLogged();

  const menuProps: INavMenu = {
    open: open,
    setOpen: setOpen,
    menuColor: menuColor
  }

  const NavItem1: INavLink = {
    link: '/search',
    text: 'Εφαρμογή'
  }

  const NavItem2: INavLink = {
    text: 'Δεδομένα'
  }

  return (
    <nav className='relative h-20 bg-inherit flex items-center z-20'>
      <NavLogo/>
      <div className='relative ml-28 flex flex-column'>
        <NavLink {...NavItem1}/>
        <NavLink {...NavItem2}/>
      </div>
      {
        isLogged ?
          <NavBarAccount/> :
            <NavButtons/>
      }
      <NavIcon {...menuProps}/>
      { open && <NavMenu {...menuProps}/> }
    </nav>
  )
}

export default NavBar