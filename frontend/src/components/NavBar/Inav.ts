import {Dispatch, SetStateAction} from 'react'

export interface INavMenu {
    open: boolean,
    setOpen: Dispatch<SetStateAction<boolean>>
    menuColor: string
}

export interface INavLink {
    link?: string,
    text: string
}

export interface INavMenuProps {
    navbarProps: string,
    menuColor: string,
    setNavbarProps: (newProps: any) => void;
}