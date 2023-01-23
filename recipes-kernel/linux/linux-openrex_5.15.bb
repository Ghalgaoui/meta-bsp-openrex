# Copyright (C) 2023 Kamel Ghalgaoui
# Released under the MIT license (see COPYING.MIT for the terms)
 
SUMMARY = "Linux Kernel for OpenRex board"
DESCRIPTION = "Linux Kernel for OpenRex board. More info \
at http://www.imx6rex.com/open-rex"
 
require recipes-kernel/linux/linux-fslc.inc

# Fetch from a git version control
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# if fetch a file from remote server other than version control "git":
# md5sum openrex-linux-fslc-5.15-master.tar.gz
# sha256sum openrex-linux-fslc-5.15-master.tar.gz
#SRC_URI[md5sum] = "c568aa2a8c4bc7fe3cb6ef38042655c7"
#SRC_URI[sha256sum] = " 6e1133b6615b81f5cfd0ea392f02d761dd9521897699e358c36c70f12e307dcc"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS += "lzop-native bc-native"

LINUX_VERSION ?= "5.15"

#PV .= "+git${SRCPV}"
PV .= ""

# TODO: WHy you use KERNEL_VERSION_SANITY_SKIP="1" ??? See kernel.bbclass file
KERNEL_VERSION_SANITY_SKIP="1"

SRCBRANCH = "kirkstone"
LOCALVERSION = "-yocto"
 
#Always update SRCREV based on your last commit
#SRCREV = "aba8070ca2dbb941788a5f5eea714e3cf8a44b65"
SRCREV = "AUTOINC"

 
KERNEL_SRC ?= "git://github.com/Ghalgaoui/openrex-linux-fslc-5.15.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRC_URI:append = " file://defconfig"

COMPATIBLE_MACHINE:openrex-imx6quad = "(mx6|mx7|openrex-imx6quad)"
