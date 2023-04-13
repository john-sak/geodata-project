import React, {useState} from 'react'
import NavLogo from './NavLogo'
import NavMenu from './NavMenu';
import NavIcon from './NavIcon';
import { INavLink, INavMenu } from './Inav';
import NavLink from './NavLink';
import NavButtons from './NavButtons';

const NavBar = () => {

  const [open, setOpen] = useState(false);

  const menuProps: INavMenu = {
    open: open,
    setOpen: setOpen
  }

  const NavItem1: INavLink = {
    link: 'DummyPage',
    text: 'Εφαρμογή'
  }

  const NavItem2: INavLink = {
    link: 'DummyPage',
    text: 'Δεδομένα'
  }

  return (
    <nav className='relative h-20 bg-slate-200 flex items-center'>
      <NavLogo/>
      <div className='relative ml-28 flex flex-column'>
        <NavLink {...NavItem1}/>
        <NavLink {...NavItem2}/>
      </div>
      <NavButtons/>
      <NavIcon {...menuProps}/>
      { open && <NavMenu {...menuProps}/> }
    </nav>
  )
}

export default NavBar