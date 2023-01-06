SUMMARY = "Linux Kernel for OpenRex board"
DESCRIPTION = "Linux Kernel for OpenRex board. More info https://www.imx6rex.com/open-rex/"

include recipes-kernel/linux/linux-fslc.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

LOCALVERSION ?= "-openrex"

SRC_URI:append:mx6q = " file://0001-Add-OpenRex-device-tree.patch \
                        file://defconfig \
                        "

COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-openrex|imx6s-openrex)"


