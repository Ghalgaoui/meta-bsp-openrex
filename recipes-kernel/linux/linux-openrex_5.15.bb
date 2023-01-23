# Copyright (C) 2023 Kamel Ghalgaoui
# Released under the MIT license (see COPYING.MIT for the terms)
 
SUMMARY = "Linux Kernel for OpenRex board"
DESCRIPTION = "Linux Kernel for OpenRex board. More info \
at http://www.imx6rex.com/open-rex"
 
require recipes-kernel/linux/linux-fslc.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS += "lzop-native bc-native"
 
#PV .= "+git${SRCPV}"
PV .= ""
 
SRCBRANCH = "kirkstone"
LOCALVERSION = "-yocto"
 
#Always update SRCREV based on your last commit
#SRCREV = "aba8070ca2dbb941788a5f5eea714e3cf8a44b65"
SRCREV = "AUTOINC"

 
KERNEL_SRC ?= "https://github.com/Ghalgaoui/openrex-linux-fslc-5.15.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
          file://defconfig \
          "

COMPATIBLE_MACHINE:openrex-imx6quad = "(mx6|mx7|openrex-imx6quad)"
